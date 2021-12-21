package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.captain;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonToProductFormsDeserializator {

	public static List<ProductForm> deserializeJsonToProductForms(String json) {
        Type token = new TypeToken<Collection<ProductForm>>() {
        }.getType();
        return new Gson().fromJson(json, token);
    }
	
}
