
package target.aula.cursoandroid.telegram;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetUpdates {

    private Boolean ok;
    private List<Result> result = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
