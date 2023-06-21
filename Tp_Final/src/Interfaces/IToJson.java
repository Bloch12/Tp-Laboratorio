package Interfaces;

import org.json.JSONException;
import org.json.JSONObject;

public interface IToJson {
    /**
     * pasa un objeto a Json
     * @return el objeto convertido en Json
     */
    JSONObject toJson();

    /**
     * pasa un json a objeto
     * @param jsonObject
     */
    void toObject(JSONObject jsonObject);
}
