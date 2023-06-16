package Interfaces;

import org.json.JSONException;
import org.json.JSONObject;

public interface IToJson {
    JSONObject toJson();
    void toObject(JSONObject jsonObject);
}
