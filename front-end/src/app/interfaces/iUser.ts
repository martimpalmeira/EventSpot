import { iEvent } from "./iEvent";

export interface iUser {
    id: string; // Identificador único do usuário
    name: string; // Nome do usuário
    email: string; // E-mail do usuário
    password?: string; // Senha do usuário (opcional e não recomendado armazenar diretamente)
    eventsParticipated: iEvent[]; // Lista de eventos nos quais o usuário está participando
  }