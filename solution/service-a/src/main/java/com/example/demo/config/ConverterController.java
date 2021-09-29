/*
 * Copyright 2019-2021 Rudy De Busscher (Payara Services)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.demo.config;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/config/converter")
@RequestScoped
public class ConverterController {

    @Inject
    @ConfigProperty(name = "myPets")
    private List<String> pets;

    @Inject
    @ConfigProperty(name = "color")
    private RGB rgbValue;

    @GET
    public String getConfigValue() {
        String myPets = String.join(" - ", pets);
        return String.format("Pets : %s, Color :  %s", myPets, rgbValue);
    }

}
