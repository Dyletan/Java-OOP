package entities;

import java.io.Serializable;
import data.Project;

public class Diploma extends Project implements Serializable{
	public Diploma() {}

	public Diploma(String topic, Researcher superviser) {
		super(topic);
	}
}
