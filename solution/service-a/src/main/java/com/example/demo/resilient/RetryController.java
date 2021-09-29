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
package com.example.demo.resilient;

import org.eclipse.microprofile.faulttolerance.Retry;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;

@Path("/retry")
@ApplicationScoped
@Retry
public class RetryController {

    private int counter = 0;

    @GET
    public String getNextEvenValue() {
        counter++;
        if (counter%2 == 0) {
            return String.valueOf(counter);
        } else {
            throw new WebApplicationException("Only even number allowed");
        }
    }
}
