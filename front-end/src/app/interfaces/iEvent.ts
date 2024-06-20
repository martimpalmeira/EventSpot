import { iUser } from "./iUser";

export interface iEvent {
    id: string; // Identificador único do evento
    name: string; // Nome do evento
    description: string; // Descrição do evento
    startDate: Date; // Data de início do evento
    endDate: Date; // Data de fim do evento
    location: string; // Localização do evento
    participants: iUser[]; // Lista de participantes do evento, representados pela interface User
  }