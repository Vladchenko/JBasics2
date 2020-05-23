/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.designpatterns.builder;

/**
 *
 * Joshua_Bloch_-_Effective_Java_2nd_Edition - page 34.
 *
 * @author v.yanchenko
 */
public class Builder {

    // Describing a planet's features.
    private double mass;                // In kilograms.
    private double radius = 0;          // In kilometers.
    private double density = 0;
    private double orbitRadius = 0;     // Radius from stars.
    private double dayDuration = 0;     // Hours per day.
    private double yearDuration = 0;    // Days per year.

//    Builder Nibiru = new
// Builder.Builder_().dayDuration(24).orbitRadius(50000).density(34).mass(12000000.0);

    public static class Builder_ {

        private double mass;
        private double radius = 0;
        private double density = 0;
        private double orbitRadius = 0;
        private double dayDuration = 0;
        private double yearDuration = 0;

        public Builder_ mass(double value) {
            mass = value;
            return this;
        }
        public Builder_ radius(double value) {
            radius = value;
            return this;
        }
        public Builder_ density(double value) {
            density = value;
            return this;
        }
        public Builder_ orbitRadius(double value) {
            orbitRadius = value;
            return this;
        }
        public Builder_ dayDuration(double value) {
            dayDuration = value;
            return this;
        }
        public Builder_ yearDuration(double value) {
            yearDuration = value;
            return this;
        }

    }
}
