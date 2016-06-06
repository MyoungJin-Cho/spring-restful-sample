package io.jubilie.restful.sample;

public interface SampleApiClient {

    public UserResponse createUser(UserRequest request);

    public UserResponse updateUser(UserRequest request);

    public UserResponse getUser(String id);

    public UserResponse deleteUser(String id);
}
