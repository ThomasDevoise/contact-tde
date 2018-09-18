package fr.lps2ima.contact;

import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;

import java.util.Optional;

import org.easymock.EasyMock;
import org.easymock.EasyMockRule;
import org.junit.*;
import org.junit.Rule;

public class ContactServiceMockTest extends EasyMockSupport{
	
	@Rule
	public EasyMockRule rule = new EasyMockRule(this);
	
	@TestSubject
	private ContactService service = new ContactService();
	
	@Mock
	private IContactDAO contactDao;
	
	@Test(expected = ContactExistException.class)
	public void testAddContact() throws ContactExistException {
		Contact contact = new Contact();
		//1- Enregistrement des comportements mocks
		EasyMock.expect(contactDao.findByName("VousMettezLaValeurQueVousVoulez")).andReturn(Optional.of(contact));
		//2- Fin d'enregistrement
		replayAll();
		//3- Test
		service.addContact("VousMettezLaValeurQueVousVoulez");
	}
	
	@Test(expected = ContactNotFound.class)
	public void testRemoveContact() throws ContactNotFound {

		//1- Enregistrement des comportements mocks
		EasyMock.expect(contactDao.findByName("Thomas")).andReturn(Optional.empty());
		//2- Fin d'enregistrement
		replayAll();
		//3- Test
		service.deleteContact("Thomas");
	}
}
