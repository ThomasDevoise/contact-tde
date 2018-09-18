package fr.lps2ima.contact;

import org.junit.Test;

public class ContactServiceTest {

    private ContactService service = new ContactService();

    @Test
    public void shouldAddContact() throws ContactExistException {
        service.addContact("Arnaud Thorel");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailOnNull() throws ContactExistException {
        service.addContact(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailOnShortNames() throws ContactExistException {
        service.addContact("Oh");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailOnLongNames() throws ContactExistException {
        service.addContact("166419333393030640591664193333930306405916641933339303064059166419333393030640591");
    }

    @Test(expected = ContactExistException.class)
    public void shouldFailOnExistingNames() throws ContactExistException {
        service.addContact("Georges Abitbol");
        service.addContact("Georges Abitbol");
    }
    
    @Test(expected = ContactNotFound.class)
    public void shouldFailRemoveContact() throws ContactNotFound {
    	service.deleteContact("Thomas Devoise");
    }
    
    @Test
    public void shouldRemoveContact() throws ContactNotFound, ContactExistException {
    	service.addContact("Contact001");
    	service.deleteContact("Contact001");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void removeShouldFailOnNull()throws ContactNotFound{
    	service.deleteContact(null);
    }
}
