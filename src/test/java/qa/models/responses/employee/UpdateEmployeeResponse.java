package qa.models.responses.employee;

public class UpdateEmployeeResponse {
    public Data data;

    public static class Data {
        public updateEmployee updateEmployee;
    }

    public static class updateEmployee {
        public String id;
    }
}