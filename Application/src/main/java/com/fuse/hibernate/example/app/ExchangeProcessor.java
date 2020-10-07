package com.fuse.hibernate.example.app;
import com.fuse.hibernate.example.model.Person;
import com.fuse.hibernate.example.service.PersonServiceImpl;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class ExchangeProcessor implements Processor {

    @Reference
    private PersonServiceImpl personService;
    static Logger LOG = LoggerFactory.getLogger(ExchangeProcessor.class);



    @Override
    public void process(Exchange exchange) throws Exception {

        LOG.info("INSIDE PROCESS:##:"+ exchange.getIn().getBody(Person.class));
        Person p =exchange.getIn().getBody(Person.class);
        String str = (String)exchange.getIn().getBody();
        p = new Person("Deepak", "Delhi", "India");
        personService.createPerson(p);
        List<Person> list=personService.findPersons();
        LOG.info("output list.size::::::"+list.size());
    }


    public PersonServiceImpl getPersonService() {
        return personService;
    }

    public void setPersonService(PersonServiceImpl personService) {
        this.personService = personService;
    }

}
