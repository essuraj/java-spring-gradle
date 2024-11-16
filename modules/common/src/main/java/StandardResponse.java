public record StandardResponse<T>(boolean success, String message, T data) {
    public static <T> StandardResponse<T> success(T data) {
        return new StandardResponse<>(true, null, data);
    }

    public static <T> StandardResponse<T> error(String message) {
        return new StandardResponse<>(false, message, null);
    }
}
