package Assignment2;

public class DefaultSampler implements Sampler {
	public double read() {
		return Math.random() * 10;
	}
}