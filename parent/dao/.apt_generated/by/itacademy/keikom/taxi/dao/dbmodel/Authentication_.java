package by.itacademy.keikom.taxi.dao.dbmodel;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Authentication.class)
public abstract class Authentication_ {

	public static volatile SingularAttribute<Authentication, String> password;
	public static volatile SingularAttribute<Authentication, Timestamp> created;
	public static volatile SingularAttribute<Authentication, Timestamp> modified;
	public static volatile SingularAttribute<Authentication, String> login;
	public static volatile SingularAttribute<Authentication, Integer> userId;

}

