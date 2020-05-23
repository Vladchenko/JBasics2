/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.designpatterns.builder;

/**
 *
 * @author v.yanchenko
 */
public class Planet {

    // Describing a planet's features.
    private double mass;                // In kilograms.
    private double radius = 0;          // In kilometers.
    private double density = 0;
    private double orbitRadius = 0;     // Radius from stars.
    private double dayDuration = 0;     // Hours per day.
    private double yearDuration = 0;    // Days per year.

    Planet Nibiru = new PlanetBuilder().dayDuration(24).
            orbitRadius(50000).density(34).mass(12000000.0).build();

    public static class PlanetBuilder {

        private double mass;
        private double radius = 0;
        private double density = 0;
        private double orbitRadius = 0;
        private double dayDuration = 0;
        private double yearDuration = 0;

        public PlanetBuilder mass(double value) {
            mass = value;
            return this;
        }
        public PlanetBuilder radius(double value) {
            radius = value;
            return this;
        }
        public PlanetBuilder density(double value) {
            density = value;
            return this;
        }
        public PlanetBuilder orbitRadius(double value) {
            orbitRadius = value;
            return this;
        }
        public PlanetBuilder dayDuration(double value) {
            dayDuration = value;
            return this;
        }
        public PlanetBuilder yearDuration(double value) {
            yearDuration = value;
            return this;
        }

        public Planet build() {
            return new Planet();
        }

    }
}
