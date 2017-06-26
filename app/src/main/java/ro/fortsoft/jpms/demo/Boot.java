/*
 * Copyright 2017 Decebal Suiu
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
package ro.fortsoft.jpms.demo;

import ro.fortsoft.jpms.demo.api.Greeting;

import java.util.ServiceLoader;

/**
 * A boot class that start the demo.
 *
 * @author Decebal Suiu
 */
public class Boot {

    public static void main(String[] args) {
        ServiceLoader<Greeting> providers = ServiceLoader.load(Greeting.class);
        providers.stream().forEach(provider -> {
            Greeting greeting = provider.get();
            System.out.println(greeting.getClass().getName() + " > " + greeting.getGreeting());
        });
    }

}
