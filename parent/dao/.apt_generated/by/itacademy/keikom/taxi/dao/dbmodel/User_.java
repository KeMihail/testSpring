package by.itacademy.keikom.taxi.dao.dbmodel;

import by.itacademy.keikom.taxi.dao.enums.UserRole;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, Timestamp> birthday;
	public static volatile SingularAttribute<User, String> lastName;
	public static volatile SingularAttribute<User, String> address;
	public static volatile SingularAttribute<User, UserRole> role;
	public static volatile SingularAttribute<User, Timestamp> created;
	public static volatile ListAttribute<User, Car> cars;
	public static volatile SingularAttribute<User, String> phoneNumber;
	public static volatile SingularAttribute<User, Boolean> deleted;
	public static volatile SingularAttribute<User, String> name;
	public static volatile SingularAttribute<User, Timestamp> modified;
	public static volatile ListAttribute<User, Order> orders;
	public static volatile SingularAttribute<User, Integer> id;
	public static volatile SingularAttribute<User, String> email;

}

