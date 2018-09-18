package fr.lps2ima.contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContactDao implements IContactDAO {

    private List<Contact> contacts = new ArrayList<>();

    /* (non-Javadoc)
	 * @see fr.lps2ima.contact.IContactDAO#readAll()
	 */
	@Override
	public List<Contact> readAll() {
        return contacts;
    }

    /* (non-Javadoc)
	 * @see fr.lps2ima.contact.IContactDAO#findByName(java.lang.String)
	 */
	@Override
	public Optional<Contact> findByName(String name) {
        return contacts.stream()//
                .filter(x -> name.equals(x.getName()))//
                .findFirst();
    }

    /* (non-Javadoc)
	 * @see fr.lps2ima.contact.IContactDAO#add(fr.lps2ima.contact.Contact)
	 */
	@Override
	public void add(Contact contact) {
        contacts.add(contact);
    }
	
	public void remove(Contact contact){
		contacts.remove(contact);
		
	}
}
