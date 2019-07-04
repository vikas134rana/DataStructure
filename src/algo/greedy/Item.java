package algo.greedy;

public class Item {

	private float value;
	private float weight;

	public Item(float value, float weight) {
		this.value = value;
		this.weight = weight;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "(V:" + value + " , W:" + weight + ")";
	}

}
