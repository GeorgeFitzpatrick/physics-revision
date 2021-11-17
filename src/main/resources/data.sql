CREATE TABLE IF NOT EXISTS years
(
    id    LONG AUTO_INCREMENT PRIMARY KEY NOT NULL,
    title VARCHAR                         NOT NULL
);

CREATE TABLE IF NOT EXISTS modules
(
    id      LONG AUTO_INCREMENT PRIMARY KEY NOT NULL,
    year_id LONG                            NOT NULL,
    title   VARCHAR                         NOT NULL,
    image   VARCHAR                         NOT NULL
);

CREATE TABLE IF NOT EXISTS chapters
(
    id        LONG AUTO_INCREMENT PRIMARY KEY NOT NULL,
    module_id LONG                            NOT NULL,
    title     VARCHAR                         NOT NULL
);

CREATE TABLE IF NOT EXISTS flashcards
(
    id         LONG AUTO_INCREMENT PRIMARY KEY NOT NULL,
    chapter_id LONG                            NOT NULL,
    title      VARCHAR                         NOT NULL,
    url        VARCHAR                         NOT NULL
);

CREATE TABLE IF NOT EXISTS sub_chapters
(
    id          LONG AUTO_INCREMENT PRIMARY KEY NOT NULL,
    chapter_id  LONG                            NOT NULL,
    title       VARCHAR                         NOT NULL,
    page_number INTEGER                         NOT NULL
);

CREATE TABLE IF NOT EXISTS videos
(
    id             LONG AUTO_INCREMENT PRIMARY KEY NOT NULL,
    sub_chapter_id LONG                            NOT NULL,
    title          VARCHAR                         NOT NULL,
    url            VARCHAR                         NOT NULL
);

CREATE TABLE IF NOT EXISTS lessons
(
    id             LONG AUTO_INCREMENT PRIMARY KEY NOT NULL,
    sub_chapter_id LONG                            NOT NULL,
    file_path      VARCHAR                         NOT NULL
);

INSERT INTO years (id, title)
VALUES (1, 'Year 1'),
       (2, 'Year 2');


INSERT INTO modules (id, year_id, title, image)
VALUES (1, 1, 'Practical Skills', 'image/light_bulb.png'),
       (2, 1, 'Foundations of physics', 'image/bridge.png'),
       (3, 1, 'Forces and motion', 'image/cogs.png'),
       (4, 1, 'Electrons, waves, and photons', 'image/solar_panels.png'),
       (5, 2, 'Newtonian world & astrophysics', 'image/galaxy.png'),
       (6, 2, 'Particles and medical physics', 'image/atomic_model.png');

INSERT INTO chapters (id, module_id, title)
VALUES (1, 1, 'Practical Skills'),

       (2, 2, 'Foundations of physics'),

       (3, 3, 'Motion'),
       (4, 3, 'Forces in action'),
       (5, 3, 'Work, energy, and power'),
       (6, 3, 'Materials'),
       (7, 3, 'Laws of motion and momentum'),

       (8, 4, 'Charge and current'),
       (9, 4, 'Energy power and resistance'),
       (10, 4, 'Electrical circuits'),
       (11, 4, 'Waves 1'),
       (12, 4, 'Waves 2'),
       (13, 4, 'Quantum physics'),

       (14, 5, 'Thermal physics'),
       (15, 5, 'Ideal gasses'),
       (16, 5, 'Circular motion'),
       (17, 5, 'Oscillations'),
       (18, 5, 'Gravitational fields'),
       (19, 5, 'Stars'),
       (20, 5, 'Cosmology'),

       (21, 6, 'Capacitance'),
       (22, 6, 'Electric fields'),
       (23, 6, 'Magnetic fields'),
       (24, 6, 'Particle physics'),
       (25, 6, 'Radioactivity'),
       (26, 6, 'Nuclear physics'),
       (27, 6, 'Medical imaging');

INSERT INTO flashcards (chapter_id, title, url)
VALUES (1, 'Physics 1.1 - Practical Skills',
        'https://www.chegg.com/flashcards/physics-1-1-practical-skills-3d24a6c7-d808-4f88-bc69-7ee22f3cf19f/deck'),
       (2, 'Physics 2.1 - Foundations of physics',
        'https://www.chegg.com/flashcards/physics-2-1-foundations-of-physics-0ffc1508-cf91-4cc3-a0e0-68f3078b7956/deck'),
       (3, 'Physics 3.1 - Motion',
        'https://www.chegg.com/flashcards/physics-3-1-motion-79147add-0112-4973-a8cb-1bd0dc3334af/deck'),
       (11, 'Physics 4.4, 4.5 - Waves',
        'https://www.chegg.com/flashcards/physics-4-4-4-5-waves-0d621ba9-8701-498d-a3a5-5bef56cd9043/deck'),
       (12, 'Physics 4.4, 4.5 - Waves',
        'https://www.chegg.com/flashcards/physics-4-4-4-5-waves-0d621ba9-8701-498d-a3a5-5bef56cd9043/deck'),
       (14, 'Physics 5.1 - Thermal Physics & Ideal Gasses',
        'https://www.chegg.com/flashcards/physics-5-1-thermal-physics-ideal-gasses-3be1445d-a5a6-4175-8754-193ecf1b3036/deck'),
       (15, 'Physics 5.1 - Thermal Physics & Ideal Gasses',
        'https://www.chegg.com/flashcards/physics-5-1-thermal-physics-ideal-gasses-3be1445d-a5a6-4175-8754-193ecf1b3036/deck'),
       (24, 'Physics 6.4 - Particle Physics',
        'https://www.chegg.com/flashcards/physics-6-4-particle-physics-91d5315f-3eb0-4455-915e-128d4685b640/desk');

INSERT INTO sub_chapters (chapter_id, title, page_number)
VALUES (1, 'Uncertainties', 560),

       (2, 'Quantities and units', 8),
       (2, 'Derived units', 10),
       (2, 'Scalar and vector quantities', 12),
       (2, 'Adding vectors', 14),
       (2, 'Resolving vectors', 16),
       (2, 'More on vectors', 18),

       (3, 'Distance and speed', 22),
       (3, 'Displacement and velocity', 24),
       (3, 'Acceleration', 27),
       (3, 'Velocity/time graphs', 29),
       (3, 'Equations of motion', 31),
       (3, 'Car stopping distances', 35),
       (3, 'Free fall and g', 37),
       (3, 'Projectile motion', 40),

       (4, 'Force, mass, and weight', 46),
       (4, 'Centre of mass', 49),
       (4, 'Free-body diagrams', 51),
       (4, 'Drag and terminal velocity', 54),
       (4, 'Moments and equilibrium', 57),
       (4, 'Couples and torques', 60),
       (4, 'Triangle of forces', 62),
       (4, 'Density and pressure', 65),
       (4, 'Archimedes'' principle', 67),

       (5, 'Work done and energy', 72),
       (5, 'Conservation of energy', 74),
       (5, 'Kinetic energy and gravitational potential energy', 76),
       (5, 'Power and efficiency', 79),

       (6, 'Springs and Hooke''s law', 84),
       (6, 'Elastic potential energy', 88),
       (6, 'Deforming materials', 90),
       (6, 'Stress-strain, and Young''s modulus', 92),

       (7, 'Newton''s first anf third laws of motion', 100),
       (7, 'Linear momentum', 102),
       (7, 'Newton''s second law of motion', 105),
       (7, 'Impulse', 107),
       (7, 'Collisions in two dimensions', 109),

       (8, 'Current and charge', 122),
       (8, 'Moving charges', 126),
       (8, 'Kirchoff''s first law', 129),
       (8, 'Mean drift velocity', 131),

       (9, 'Circuit symbols', 138),
       (9, 'Potential difference and electromotive force', 140),
       (9, 'The electron gun', 143),
       (9, 'Resistance', 145),
       (9, 'Current/Voltage characteristics', 148),
       (9, 'Diodes', 151),
       (9, 'Resistance and resistivity', 153),
       (9, 'The thermistor', 157),
       (9, 'The LDR', 160),
       (9, 'Electrical energy and power', 162),
       (9, 'Paying for electricity', 165),

       (10, 'Kirchoff''s laws and circuits', 170),
       (10, 'Combining resistors', 174),
       (10, 'Analysing circuits', 177),
       (10, 'Internal resistance', 181),
       (10, 'Potential divider circuits', 186),
       (10, 'Sensing circuits', 189),

       (11, 'Progressive waves', 194),
       (11, 'Wave properties', 197),
       (11, 'Reflection and refraction', 203),
       (11, 'Diffraction and polarisation', 205),
       (11, 'Intensity', 207),
       (11, 'Electromagnetic waves', 210),
       (11, 'Polarisation of electromagnetic waves', 213),
       (11, 'Refractive index', 215),
       (11, 'Total internal reflection', 217),

       (12, 'Superposition of waves', 222),
       (12, 'Interference', 224),
       (12, 'Young''s double slit experiment', 228),
       (12, 'Stationary waves', 231),
       (12, 'Harmonics', 234),
       (12, 'Stationary waves in air columns', 237),

       (13, 'The photon model', 242),
       (13, 'The photoelectric effect', 247),
       (13, 'Einstein''s photoelectric effect equation', 251),
       (13, 'Wave particle duality', 254),

       (14, 'Temperature', 268),
       (14, 'Solids, liquids, and gasses', 271),
       (14, 'Internal energy', 274),
       (14, 'Specific heat capacity', 276),
       (14, 'Specific latent heat', 280),

       (15, 'The kinetic theory of gasses', 286),
       (15, 'Gas laws', 289),
       (15, 'Root mean square speed', 293),
       (15, 'The Boltzmann constant', 296),

       (16, 'Angular velocity and the radian', 302),
       (16, 'Centripetal acceleration', 305),
       (16, 'Exploring centripetal forces', 309),

       (17, 'Oscillations and simple harmonic motion', 316),
       (17, 'Analysing simple harmonic motion', 320),
       (17, 'Simple harmonic motion and energy', 324),
       (17, 'Damping and driving', 327),
       (17, 'Resonance', 330),

       (18, 'Gravitational fields', 336),
       (18, 'Newton''s law of gravitation', 339),
       (18, 'Gravitational field strength for a point mass', 342),
       (18, 'Kepler''s laws', 345),
       (18, 'Satellites', 348),
       (18, 'Gravitational potential', 351),
       (18, 'Gravitational potential energy', 354),

       (19, 'Objects in the universe', 360),
       (19, 'The life cycle of stars', 363),
       (19, 'The Hertzsprung-Russel diagram', 367),
       (19, 'Energy levels in atoms', 369),
       (19, 'Spectra', 371),
       (19, 'Analysing starlight', 373),
       (19, 'Stellar luminosity', 376),

       (20, 'Astronomical distances', 382),
       (20, 'The Doppler effect', 385),
       (20, 'Hubble''s law', 388),
       (20, 'The Big Bang theory', 390),
       (20, 'Evolution of the universe', 392),

       (21, 'Capacitors', 406),
       (21, 'Capacitors in circuits', 408),
       (21, 'Energy stored by capacitors', 412),
       (21, 'Discharging capacitors', 415),
       (21, 'Charging capacitors', 420),
       (21, 'Uses of capacitors', 422),

       (22, 'Electric fields', 426),
       (22, 'Coulomb''s law', 428),
       (22, 'Capacitance', 432),
       (22, 'Charged particles', 436),
       (22, 'Electric potential energy', 439),

       (23, 'Magnetic fields', 446),
       (23, 'Understanding magnetic fields', 448),
       (23, 'Charged particles in magnetic fields', 452),
       (23, 'Electromagnetic induction', 457),
       (23, 'Faraday''s law and Lenz''s law', 461),
       (23, 'Transformers', 464),

       (24, 'Alpha-particle scattering experiment', 470),
       (24, 'The nucleus', 473),
       (24, 'Antiparticles, hadrons, and leptons', 476),
       (24, 'Quarks', 478),
       (24, 'Beta decay', 480),

       (25, 'Radioactivity', 484),
       (25, 'Nuclear decay equations', 487),
       (25, 'Half-life and activity', 491),
       (25, 'Radioactive decay calculations', 494),
       (25, 'Modelling radioactive decay', 497),
       (25, 'Radioactive dating', 499),

       (26, 'Einstein''s mass-energy equation', 504),
       (26, 'Binding energy', 507),
       (26, 'Nuclear fission', 510),
       (26, 'Nuclear fusion', 515),

       (27, 'X-rays', 520),
       (27, 'Interaction of X-rays with master', 523),
       (27, 'CAT scans', 526),
       (27, 'The gamma camera', 528),
       (27, 'PET scans', 531),
       (27, 'Ultrasounds', 533),
       (27, 'Acoustic impedance', 536),
       (27, 'Doppler imaging', 538);

INSERT INTO videos (sub_chapter_id, title, url)
VALUES (1, 'Method of mixtures (A level physics)', 'https://www.youtube.com/watch?v=0YIIYQhfWrQ');

INSERT INTO lessons (sub_chapter_id, file_path)
VALUES (1, 'lesson/chapter_1/lesson_1_uncertainty.pdf'),
       (1, 'lesson/chapter_1/lesson_2_uncertainty_two.pdf'),

       (2, 'lesson/chapter_2/lesson_1_quantities_and_units.pdf'),
       (3, 'lesson/chapter_2/lesson_2_derived_units.pdf'),
       (6, 'lesson/chapter_2/lesson_5_resolving_vectors_practical.pdf'),
       (4, 'lesson/chapter_2/lesson_6_scalars_and_vectors.pdf'),

       (8, 'lesson/chapter_3/lesson_1_speed_and_velocity.pdf'),
       (10, 'lesson/chapter_3/lesson_2_acceleration_and_velocity_time_graphs.pdf'),
       (12, 'lesson/chapter_3/lesson_3_equations_of_motion.pdf'),
       (13, 'lesson/chapter_3/lesson_4_breaking_and_stopping.pdf'),
       (14, 'lesson/chapter_3/lesson_5_free_fall_and_g.pdf'),
       (14, 'lesson/chapter_3/lesson_6_determining_g.pdf'),
       (15, 'lesson/chapter_3/lesson_7_projectile_motion.pdf'),
       (15, 'lesson/chapter_3/lesson_8_projectile_motion_2.pdf'),

       (16, 'lesson/chapter_4/lesson_1_force_and_mass.pdf'),
       (17, 'lesson/chapter_4/lesson_2_centre_of_mass.pdf'),
       (19, 'lesson/chapter_4/lesson_3_drag_and_terminal_velocity.pdf'),
       (19, 'lesson/chapter_4/lesson_4_drag_investigation.pdf'),
       (20, 'lesson/chapter_4/lesson_5_moments_and_equilibrium.pdf'),
       (21, 'lesson/chapter_4/lesson_6_couples_and_torques.pdf'),
       (23, 'lesson/chapter_4/lesson_8_density.pdf'),
       (23, 'lesson/chapter_4/lesson_9_pressure.pdf'),

       (25, 'lesson/chapter_5/lesson_1_work_and_conservation_of_energy.pdf'),
       (27, 'lesson/chapter_5/lesson_2_ke_and_gpe.pdf'),
       (28, 'lesson/chapter_5/lesson_3_power_and_efficiency.pdf'),
       (28, 'lesson/chapter_5/lesson_4_slope_efficiency.pdf'),

       (30, 'lesson/chapter_6/lesson_3_elastic_potential_energy.pdf'),
       (31, 'lesson/chapter_6/lesson_2_deformation.pdf'),
       (32, 'lesson/chapter_6/lesson_4_stress_strain_and_youngs_modulus.pdf'),

       (33, 'lesson/chapter_7/lesson_1_newtons_first_and_thrid_laws_of_motion.pdf'),
       (34, 'lesson/chapter_7/lesson_2_linear_momentum.pdf'),
       (35, 'lesson/chapter_7/lesson_4_newtons_second_law.pdf'),
       (36, 'lesson/chapter_7/lesson_5_impulse.pdf'),
       (37, 'lesson/chapter_7/lesson_3_collisions_in_two_dimensions.pdf'),

       (38, 'lesson/chapter_8/lesson_1_current.pdf'),
       (39, 'lesson/chapter_8/lesson_2_moving_charges.pdf'),
       (41, 'lesson/chapter_8/lesson_3_mean_drift_velocity.pdf'),
       (40, 'lesson/chapter_8/lesson_4_kirchoffs_law.pdf'),

       (43, 'lesson/chapter_9/lesson_1_circuits_potential_difference_and_emf.pdf'),
       (44, 'lesson/chapter_9/lesson_2_the_electron_gun.pdf'),
       (45, 'lesson/chapter_9/lesson_3_resistance.pdf'),
       (48, 'lesson/chapter_9/lesson_4_resistance_and_resistivity.pdf'),
       (51, 'lesson/chapter_9/lesson_5_power_and_electrical_energy.pdf'),

       (53, 'lesson/chapter_10/lesson_1_kirchoffs_laws_in_circuits.pdf'),
       (54, 'lesson/chapter_10/lesson_2_resistors_in_series_and_parallel.pdf'),
       (55, 'lesson/chapter_10/lesson_5_analysing_circuits.pdf'),
       (56, 'lesson/chapter_10/lesson_3_internal_resistance.pdf'),
       (57, 'lesson/chapter_10/lesson_4_potential_dividers_and_sensing_circuits.pdf'),
       (57, 'lesson/chapter_10/lesson_4a_internal_resistance_practical.pdf'),

       (59, 'lesson/chapter_11/lesson_1_classification.pdf'),
       (60, 'lesson/chapter_11/lesson_2_phase_difference.pdf'),
       (61, 'lesson/chapter_11/lesson_3_reflection_and_refraction.pdf'),
       (62, 'lesson/chapter_11/lesson_5_diffraction_and_polarisation.pdf'),
       (63, 'lesson/chapter_11/lesson_6_intensity_and_amplitude.pdf'),
       (64, 'lesson/chapter_11/lesson_7_electromagnetic_spectrum.pdf'),
       (65, 'lesson/chapter_11/lesson_8_further_polarisation.pdf'),
       (67, 'lesson/chapter_11/lesson_4_total_internal_reflection.pdf'),

       (68, 'lesson/chapter_12/lesson_9_superposition.pdf'),
       (69, 'lesson/chapter_12/lesson_10_interference.pdf'),
       (70, 'lesson/chapter_12/lesson_10a_youngs_double_slit.pdf'),
       (71, 'lesson/chapter_12/lesson_11_stationary_waves_and_harmonics.pdf'),
       (73, 'lesson/chapter_12/lesson_12_stationary_waves_in_air_columns.pdf'),

       (78, 'lesson/chapter_14/lesson_1_temperature.pdf'),
       (79, 'lesson/chapter_14/lesson_2_phases_of_matter.pdf'),
       (80, 'lesson/chapter_14/lesson_3_internal_energy.pdf'),
       (81, 'lesson/chapter_14/lesson_5_specific_heat_capacity.pdf'),
       (82, 'lesson/chapter_14/lesson_6_specific_latent_heat.pdf'),

       (83, 'lesson/chapter_15/lesson_1_the_kinetic_theory_of_gasses.pdf'),
       (84, 'lesson/chapter_15/lesson_2_gas_laws.pdf'),
       (84, 'lesson/chapter_15/lesson_3_boyles_law.pdf'),
       (84, 'lesson/chapter_15/lesson_4_estimating_absolute_zero.pdf'),
       (84, 'lesson/chapter_15/lesson_5_ideal_gas_equation.pdf'),
       (85, 'lesson/chapter_15/lesson_6_root_mean_square_speed.pdf'),
       (86, 'lesson/chapter_15/lesson_7_the_boltzmann_constant.pdf'),

       (87, 'lesson/chapter_16/lesson_1_angular_velocity.pdf'),
       (88, 'lesson/chapter_16/lesson_2_centripetal_acceleration.pdf'),
       (89, 'lesson/chapter_16/lesson_3_exploring_centripetal_forces.pdf'),
       (89, 'lesson/chapter_16/lesson_4_centripetal_force_calculations.pdf'),

       (90, 'lesson/chapter_17/lesson_1_oscillations_and_shm.pdf'),
       (91, 'lesson/chapter_17/lesson_2_graphing_and_shm.pdf'),
       (92, 'lesson/chapter_17/lesson_4_energy_in_shm.pdf'),
       (93, 'lesson/chapter_17/lesson_5_damping.pdf'),
       (94, 'lesson/chapter_17/lesson_6_resonance.pdf'),

       (95, 'lesson/chapter_18/lesson_1_gravitational_fields.pdf'),
       (96, 'lesson/chapter_18/lesson_2_laws_of_gravitation.pdf'),
       (98, 'lesson/chapter_18/lesson_3_keplers_law.pdf'),
       (99, 'lesson/chapter_18/lesson_4_satellites.pdf'),
       (100, 'lesson/chapter_18/lesson_5_gravitational_potential.pdf'),
       (101, 'lesson/chapter_18/lesson_6_gravitational_potential_energy.pdf'),

       (102, 'lesson/chapter_19/lesson_1_stars.pdf'),
       (103, 'lesson/chapter_19/lesson_2_stars_two.pdf'),
       (105, 'lesson/chapter_19/lesson_3_energy_levels_in_Atoms_and_spectra.pdf'),
       (107, 'lesson/chapter_19/lesson_4_analysing_starlight.pdf'),
       (108, 'lesson/chapter_19/lesson_5_luminosity.pdf'),

       (109, 'lesson/chapter_20/lesson_1_astronomical_distance.pdf'),
       (110, 'lesson/chapter_20/lesson_2_the_doppler_effect.pdf'),
       (111, 'lesson/chapter_20/lesson_3_hubbles_law.pdf'),
       (112, 'lesson/chapter_20/lesson_4_big_bang_theory.pdf'),

       (114, 'lesson/chapter_21/lesson_1_structure_use_and_energy.pdf'),
       (115, 'lesson/chapter_21/lesson_2_connecting_capacitors.pdf'),
       (117, 'lesson/chapter_21/lesson_3_charge_storing_and_discharging.pdf'),
       (118, 'lesson/chapter_21/lesson_4_charging_capacitors.pdf'),
       (118, 'lesson/chapter_21/lesson_5_charging_capacitors_two.pdf'),

       (121, 'lesson/chapter_22/lesson_1_electric_fields_and_coulombs_law.pdf'),
       (122, 'lesson/chapter_22/lesson_2_electric_fields_and_capacitance.pdf'),
       (123, 'lesson/chapter_22/lesson_3_charged_particles_in_uniform_electric_fields.pdf'),
       (124, 'lesson/chapter_22/lesson_4_electric_potential_and_potential_energy.pdf'),

       (125, 'lesson/chapter_23/lesson_1_magnetic_fields_and_magnetic_flux_density.pdf'),
       (127, 'lesson/chapter_23/lesson_2_charged_particles_in_a_magnetic_field.pdf'),
       (128, 'lesson/chapter_23/lesson_3_electromagnetic_induction.pdf'),
       (129, 'lesson/chapter_23/lesson_4_faradays_law_and_lenzs_law.pdf'),
       (130, 'lesson/chapter_23/lesson_5_transformers.pdf'),

       (131, 'lesson/chapter_24/lesson_1_alpha_particle_scattering_experiment.pdf'),
       (132, 'lesson/chapter_24/lesson_2_the_nucleus.pdf'),
       (133, 'lesson/chapter_24/lesson_3_fundamental_particles.pdf');