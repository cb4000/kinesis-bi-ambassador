package io.datanomnom.kinesissuite;

public class Fact {

	private final String source;
	private final String when;
	private final String what;

	public Fact(String source, String when , String what) {
		this.source = source;
		this.when = when;
		this.what = what;
	}

    public String toString(){
        return "Source: "+source+" "+"When: "+when+" "+"What: "+what;
    }
}