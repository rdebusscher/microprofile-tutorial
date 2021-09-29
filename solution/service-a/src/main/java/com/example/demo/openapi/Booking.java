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
package com.example.demo.openapi;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name="Booking")
public class Booking {
    @Schema(required = true, description = "Booking id")
    private String id;
    @Schema(required = true, description = "Description of the destination")
    private Destination destination;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public static Booking booking(String id, Destination destination) {
        Booking result = new Booking();
        result.setId(id);
        result.setDestination(destination);
        return result;
    }
}
