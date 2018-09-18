package fr.lps2ima.contact;

public class ContactService {

    private IContactDAO dao = new ContactDao();

    public void addContact(String name) throws ContactExistException {
        if (name == null || name.length() < 3 || name.length() > 40) {
            throw new IllegalArgumentException("Name should be valid (3 - 40 cars)");
        }

        if (dao.findByName(name).isPresent()) {
            throw new ContactExistException("contact with name " + name + " already exists");
        }

        Contact contact = new Contact();
        contact.setName(name);
        dao.add(contact);

    }
    
    public void deleteContact(String name) throws ContactNotFound {
    	if(name == null){
    		throw new IllegalArgumentException("Name should be valid");
    	}
    	
    	Contact contact = dao.findByName(name)//
    			.orElseThrow(() -> new ContactNotFound("Contact " + name + " found"));
    	dao.remove(contact);
    	
    }
   
}
