INSERT INTO tb_doctor (name, email, phone, specialty) VALUES
('Dr. João Silva', 'joao.silva@email.com', '11987654321', 'Cardiologia'),
('Dra. Maria Souza', 'maria.souza@email.com', '11998765432', 'Ortopedia'),
('Dr. Carlos Lima', 'carlos.lima@email.com', '11991234567', 'Neurologia'),
('Dra. Ana Costa', 'ana.costa@email.com', '11993456789', 'Pediatria');

INSERT INTO tb_patient (name, email, phone) VALUES
('Carlos Souza', 'carlos.souza@email.com', '11987654321'),
('Mariana Lima', 'mariana.lima@email.com', '11998765432'),
('Roberto Alves', 'roberto.alves@email.com', '11991234567'),
('Fernanda Castro', 'fernanda.castro@email.com', '11993456789');

INSERT INTO tb_consultation (doctor_id, patient_id, start_at, end_at, date, status) VALUES
(1, 1, '2023-10-15 09:00:00', '2023-10-15 09:30:00', '2023-10-15', 'APPOINTMENT'),
(2, 2, '2023-10-16 10:30:00', '2023-10-16 11:00:00', '2023-10-16', 'APPOINTMENT'),
(3, 3, '2023-10-17 14:00:00', '2023-10-17 14:30:00', '2023-10-17', 'APPOINTMENT'),
(4, 4, '2023-10-18 11:00:00', '2023-10-18 11:30:00', '2023-10-18', 'APPOINTMENT'),
(1, 2, '2023-10-19 08:00:00', '2023-10-19 08:30:00', '2023-10-19', 'CANCELLED'),
(2, 3, '2023-10-20 13:00:00', '2023-10-20 13:30:00', '2023-10-20', 'CARRIED_OUT'),
(3, 4, '2023-10-21 16:00:00', '2023-10-21 16:30:00', '2023-10-21', 'APPOINTMENT'),
(4, 1, '2023-10-22 12:00:00', '2023-10-22 12:30:00', '2023-10-22', 'CARRIED_OUT');
