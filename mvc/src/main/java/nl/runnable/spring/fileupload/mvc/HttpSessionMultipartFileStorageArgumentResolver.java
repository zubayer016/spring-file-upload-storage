package nl.runnable.spring.fileupload.mvc;

import nl.runnable.spring.fileupload.MultipartFileStorage;
import nl.runnable.spring.fileupload.SessionMultipartFileStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Laurens Fridael
 */
public class HttpSessionMultipartFileStorageArgumentResolver implements HandlerMethodArgumentResolver {

  final static String REQUEST_ATTRIBUTE = HttpSessionMultipartFileStorage.class.getName();

  @Autowired
  private MultipartFileStorage storage;

  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    return SessionMultipartFileStorage.class.isAssignableFrom(parameter.getParameterType());
  }

  @Override
  public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
    HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
    HttpSessionMultipartFileStorage sessionStorage = new HttpSessionMultipartFileStorage(storage, request);
    request.setAttribute(REQUEST_ATTRIBUTE, sessionStorage);
    return sessionStorage;
  }

}
