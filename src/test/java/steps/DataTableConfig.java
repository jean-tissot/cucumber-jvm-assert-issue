package steps;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.DefaultDataTableEntryTransformer;
import type.NumberedObject;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

@SuppressWarnings("unused")
public class DataTableConfig {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @DefaultDataTableEntryTransformer
    public Object transformDataTable(Map<String, String> datatable, Type targetType) {
        if (targetType instanceof ParameterizedType parameterizedType && isNumberedObjectType(parameterizedType)) {
            Type objectType = parameterizedType.getActualTypeArguments()[0];
            int number = Integer.parseInt(datatable.get("#"));
            datatable.remove("#");
            return new NumberedObject<>(number, convert(datatable, objectType));
        }
        return convert(datatable, targetType);
    }

    private boolean isNumberedObjectType(ParameterizedType parameterizedType) {
        return parameterizedType.getRawType() instanceof Class<?> rawClass && rawClass.equals(NumberedObject.class);
    }

    private Object convert(Map<String, String> datatable, Type targetType) {
        return objectMapper.convertValue(datatable, objectMapper.constructType(targetType));
    }
}
