package by.itacademy.keikom.taxi.dao.dbmodel;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LegalEntity.class)
public abstract class LegalEntity_ extends by.itacademy.keikom.taxi.dao.dbmodel.AbstractModel_ {

	public static volatile ListAttribute<LegalEntity, Car> cars;
	public static volatile SingularAttribute<LegalEntity, String> address;
	public static volatile SingularAttribute<LegalEntity, String> phoneNumber;
	public static volatile SingularAttribute<LegalEntity, String> name;
	public static volatile SingularAttribute<LegalEntity, String> email;

}

