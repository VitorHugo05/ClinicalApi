INSERT INTO tb_doctor (name, email, phone, specialty, password, user_role) VALUES
('João Silva', 'joao.silva@email.com', '11987654321', 'Cardiologia', '$2a$12$1m.P9dRuvAPnLnCJ73leh.j.lEp/KaIYuOC8CUN/QruFiXHgoNJA2', 'DOCTOR'),
('Maria Souza', 'maria.souza@email.com', '11998765432', 'Ortopedia', '$2a$12$NyTzYOY6jnOUxZHOD0RvfuHW.DousQPPtWO6iNePgouddQuQts/L.', 'DOCTOR'),
('Carlos Lima', 'carlos.lima@email.com', '11991234567', 'Neurologia', '$2a$12$sSigat3NNmy9.rdx.3AIu.iWKzp3F2P7mji4DmCtkrDpqv1bWFxJm', 'DOCTOR'),
('Ana Costa', 'ana.costa@email.com', '11993456789', 'Pediatria', '$2a$10$Ae7KOSvIz33god8OYa/mZOlYR3GqBROEdh1j5wAjd4ZWpkbJMjRDe', 'DOCTOR');

INSERT INTO tb_patient (name, email, phone, password, user_role) VALUES
('Carlos Souza', 'carlos.souza@email.com', '11987654321', '$2a$12$5QEp/U0RK3o0O96yv5cGVePGMeuNYkaGVZg/KHd0z.7Wkg0WNNo/u', 'PATIENT'),
('Mariana Lima', 'mariana.lima@email.com', '11998765432', '$2a$12$qlGjXQUf3sVrxOi.lnMX0.uhllskD.ZfWH.KTHOJaB4p6Ah5tiZni', 'PATIENT'),
('Roberto Alves', 'roberto.alves@email.com', '11991234567', '$2a$12$FMD7u4XGXp8zg7rRj/TveeeSB.G9MirWMU6dixZDq9FjnUwp9pNI.', 'PATIENT'),
('Fernanda Castro', 'fernanda.castro@email.com', '11993456789', '$2a$12$EATr1IfhteUM1IIJzW8rVu.asGhbuiEcAIvtC3RACFaJjZrJRVOg6', 'PATIENT');

INSERT INTO tb_consultation (doctor_id, patient_id, start_at, end_at, date, status) VALUES
(1, 1, '09:00:00', '09:30:00', '2023-10-15', 'APPOINTMENT'),
(2, 2, '10:30:00', '11:00:00', '2023-10-16', 'APPOINTMENT'),
(3, 3, '14:00:00', '14:30:00', '2023-10-17', 'APPOINTMENT'),
(4, 4, '11:00:00', '11:30:00', '2023-10-18', 'APPOINTMENT'),
(1, 2, '08:00:00', '08:30:00', '2023-10-19', 'CANCELLED'),
(2, 3, '13:00:00', '13:30:00', '2023-10-20', 'CARRIED_OUT'),
(3, 4, '16:00:00', '16:30:00', '2023-10-21', 'APPOINTMENT'),
(4, 1, '12:00:00', '12:30:00', '2023-10-22', 'CARRIED_OUT');
