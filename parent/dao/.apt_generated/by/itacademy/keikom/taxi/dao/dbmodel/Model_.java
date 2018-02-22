package by.itacademy.keikom.taxi.dao.dbmodel;

import by.itacademy.keikom.taxi.dao.enums.BodyType;
import by.itacademy.keikom.taxi.dao.enums.CarKit;
import by.itacademy.keikom.taxi.dao.enums.EngineType;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Model.class)
public abstract class Model_ extends by.itacademy.keikom.taxi.dao.dbmodel.AbstractModel_ {

	public static volatile SingularAttribute<Model, CarKit> carCit;
	public static volatile ListAttribute<Model, Car> cars;
	public static volatile SingularAttribute<Model, String> name;
	public static volatile SingularAttribute<Model, EngineType> engineType;
	public static volatile SingularAttribute<Model, BodyType> BodyType;
	public static volatile SingularAttribute<Model, Brand> brand;

}

