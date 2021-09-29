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
package com.example.demo.metric;

import org.eclipse.microprofile.metrics.Histogram;
import org.eclipse.microprofile.metrics.annotation.Metric;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Random;

@Path("/histo")
@ApplicationScoped
public class HistogramController {

    @Inject
    @Metric(name = "Random Number Histogram")
    private Histogram histo;

    @GET
    public String calculateRandomNumberHistogram() {
        Random rnd = new Random();
        for (int i = 0; i < 1000; i++) {
            histo.update(rnd.nextInt(100) - 50);
        }
        return "See Metric page for Random Number Histogram";
    }
}
