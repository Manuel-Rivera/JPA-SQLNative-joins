package com.jpanativesql.nativesql;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.test.annotation.Rollback;

import com.jpanativesql.nativesql.entities.Student;
import com.jpanativesql.nativesql.entities.User;
import com.jpanativesql.nativesql.entities.UserRole;
import com.jpanativesql.nativesql.entities.DTOS.IUserRolDTO;
import com.jpanativesql.nativesql.entities.DTOS.UserRolDTO;
import com.jpanativesql.nativesql.repository.StudentRepository;
import com.jpanativesql.nativesql.repository.UserRepository;
import com.jpanativesql.nativesql.repository.UserRolRepository;
import com.jpanativesql.nativesql.service.UserRolService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@SpringBootTest
class NativesqlApplicationTests {
//----------------------------------------TEST STUDENT
	@Autowired
	StudentRepository studentRepository;
	@Test
	public void testStudentCreate(){
		Student studen= new Student();
		studen.setFirstName("Manuel");
		studen.setLastName("Rivera");
		studen.setScore(14);

		Student studen2 = new Student();
		studen2.setFirstName("Gaby");
		studen2.setLastName("Pineda");
		studen2.setScore(100);
		studentRepository.save(studen);
		studentRepository.save(studen2);
	}

	@Test
	public void testFindAllStudents(){
		List<Student> studentlist=studentRepository.findAllStudents(PageRequest.of(0, 5));
		studentlist.forEach(System.out::println);
		studentlist.forEach(student-> System.out.println(student));
	}
	@Test
	public void testFindAllStudentsPartial(){
		List<Object[]> partialData=studentRepository.findAllStudensPartialData();
		for(Object[] objects:partialData){
			System.out.println(objects[0]);
			System.out.println(objects[1]);
		}
	}

	@Test 
	public void testFindAllStudentsByFirstName(){
		System.out.println(studentRepository.findAllStudentsByFirstName("Manuel"));
	}
	@Test
	public void testFindAllStudentsByScores(){
		System.out.println(studentRepository.findStudentForGivenScores(0, 100));
	}

	@Test
	@Modifying
	@Transactional
	@Rollback(false)
	public void testDeleteStudentsByFirstName(){
		studentRepository.deleteStudentsByFirstName("Manuel");
	}
	//NATIVEQUERY
	@Test
	public void testFindAllStudentsNQ(){
		System.out.println(studentRepository.findAllStudentNQ());
	}

	@Test
	public void testFindByFirstNameNQ(){
		System.out.println(studentRepository.findByFirstNQ("GABY"));
	}


	//---------------------------TEST USER ROL

	@Autowired
    private UserRepository userRepository;
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private UserRolService serviceusersol;
	@Autowired
	private UserRolRepository userRolRepository;

    @Test
	@Transactional
    public void testFindByRole() {
        // Crear usuarios y roles
        User user1 = new User();
        user1.setUsername("user1");
        userRepository.save(user1);

        User user2 = new User();
        user2.setUsername("user2");
        userRepository.save(user2);

        UserRole userRole1 = new UserRole();
        userRole1.setUserId(user1.getId());
        userRole1.setRole("ADMIN");
        entityManager.persist(userRole1);

        UserRole userRole2 = new UserRole();
        userRole2.setUserId(user2.getId());
        userRole2.setRole("USER");
        entityManager.persist(userRole2);
		
        // Realizar la consulta utilizando el repositorio
        List<User> users = userRepository.findByRole("ADMIN");
        users.forEach(user-> System.out.println(user));



		//------------------Return DTO 

		//Using Entity Manager
		System.out.println("Using Entity Manager return UserRolDTO");
		List<UserRolDTO> result=serviceusersol.getUserRol();
		result.forEach(s->System.out.println(s));

		//Return objects
		System.out.println("Using Objects return Object[]");
		List <Object[]>userol=userRolRepository.getUserRolList();
		userol.forEach(s->System.out.println(s[1]));

		//Using Interface
		System.out.println("Using Interface return IUserRolDTO");
		List<IUserRolDTO> useroldto=userRolRepository.getUserRolListInterface();
		useroldto.forEach(s->System.out.println(s.getrole()));


    }
}


