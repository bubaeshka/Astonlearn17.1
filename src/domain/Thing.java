package domain;

import java.util.HashMap;
import java.util.Map;

public abstract class Thing {

    private String name;
    //protected String name;


    public Thing(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Thing [name=" + name + "]";
    }


	public Map<String, String> getHumanReadableFieldMap(){
		var res = new HashMap<String, String>();
		res.put("name","обобщенное название");
		return res;
	}
}
