package io.datanomnom.kinesissuite;

public class Fact {

	private final String source;
	private final String when;
	private final String what;

	public Fact(String _source, String _when , String _what) {
		this.source = _source;
		this.when = _when;
		this.what = _what;
	}

    public String toString(){
        return "Source: "+source+" "+"When: "+when+" "+"What: "+what;
    }
}