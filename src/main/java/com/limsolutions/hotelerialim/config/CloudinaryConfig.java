package com.limsolutions.hotelerialim.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class CloudinaryConfig {

    @Bean
    Cloudinary cloudinary(){
        return new Cloudinary(ObjectUtils.asMap(
        "cloud_name","dyepwxbcr",
        "api_key","575864119997421",
        "api_secret","WXXZRkhZPqtyw3tuP_GjzbqElfE"
        ));
    }
}