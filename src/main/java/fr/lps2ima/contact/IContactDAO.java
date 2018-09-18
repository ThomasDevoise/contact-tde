package fr.lps2ima.contact;

import java.util.List;
import java.util.Optional;

public interface IContactDAO {

	/* (non-Javadoc)
	 * @see fr.lps2ima.contact.IConractDAO#readAll()
	 */
	List<Contact> readAll();

	/* (non-Javadoc)
	 * @see fr.lps2ima.contact.IConractDAO#findByName(java.lang.String)
	 */
	Optional<Contact> findByName(String name);

	/* (non-Javadoc)
	 * @see fr.lps2ima.contact.IConractDAO#add(fr.lps2ima.contact.Contact)
	 */
	void add(Contact contact);

	void remove(Contact contact);
	
}