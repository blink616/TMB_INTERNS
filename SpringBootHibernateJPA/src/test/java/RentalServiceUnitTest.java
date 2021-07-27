import com.covid.info.domain.Person;
import com.covid.info.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class RentalServiceUnitTest {

    @Autowired
    private TestEntityManager entityManager;

    @MockBean
    private PersonRepository personRepository;

    // write test cases here

    @Test
    public void whenFindByName_thenReturnPerson() {
        // given
        Person person = new Person();
        person.setId(1);
        person.setLast_name("butt");
//        Rental rental = new Rental();
//        rental.setId(1);
//        Car car = new Car();
//        car.setId(1);
//        entityManager.persist(rental);
        entityManager.persist(person);
//        entityManager.persist(car);
        entityManager.flush();

        // when
        Person p = personRepository.getOne(1);

        // then
        assertThat(p.getLast_name())
                .isEqualTo(person.getLast_name());

    }
}
