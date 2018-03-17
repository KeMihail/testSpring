package by.itacademy.keikom.taxi.web.dto;

public class DriverDTO extends UserDTO {

	private Integer carId;
	private String carModel;
	private String carBrand;

	public DriverDTO() {

	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}
}
