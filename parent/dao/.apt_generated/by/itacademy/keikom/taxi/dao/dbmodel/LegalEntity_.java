package by.itacademy.keikom.taxi.dao.dbmodel;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LegalEntity.class)
public abstract class LegalEntity_ {

	public static volatile ListAttribute<LegalEntity, Car> cars;
	public static volatile SingularAttribute<LegalEntity, String> address;
	public static volatile SingularAttribute<LegalEntity, String> phoneNumber;
	public static volatile SingularAttribute<LegalEntity, Timestamp> created;
	public static volatile SingularAttribute<LegalEntity, String> name;
	public static volatile SingularAttribute<LegalEntity, Timestamp> modified;
	public static volatile SingularAttribute<LegalEntity, Integer> id;
	public static volatile SingularAttribute<LegalEntity, String> email;

}

