package co.com.booker.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class ResponseBodyList<T> implements Question<List<T>> {

    private final Class<T> tClass;
    private final String path;

    public ResponseBodyList(Class<T> tClass, String path) {
        this.tClass = tClass;
        this.path = path;
    }

    @Override
    public List<T> answeredBy(Actor actor) {
        return SerenityRest.lastResponse().body().jsonPath().getList(path, tClass);
    }
}