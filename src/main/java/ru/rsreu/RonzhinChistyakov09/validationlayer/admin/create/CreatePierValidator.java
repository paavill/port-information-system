package ru.rsreu.RonzhinChistyakov09.validationlayer.admin.create;

public class CreatePierValidator {

	private int maxCapacity;
	private int minCapacity;

	public CreatePierValidator(int maxCapacity, int minCapacity) {
		super();
		this.maxCapacity = maxCapacity;
		this.minCapacity = minCapacity;
	}

	public boolean validate(Integer value) {
		if (value != null) {
			return !(value > this.maxCapacity || value < this.minCapacity);
		} else {
			return false;
		}
	}

}
