import { Component } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';

import { Router, ActivatedRoute } from '@angular/router';
import { EventService } from '../../services/event.service';
import { ToastrService } from 'ngx-toastr';
import { HeaderComponent } from '../../components/header/header.component';

@Component({
  selector: 'app-create-event',
  standalone: true,
  imports: [ReactiveFormsModule, HeaderComponent],
  templateUrl: './create-event.component.html',
  styleUrl: './create-event.component.css',
})
export class CreateEventComponent {
  eventForm: FormGroup;
  eventId: string;

  constructor(
    private fb: FormBuilder,
    private eventService: EventService,
    private router: Router,
    private route: ActivatedRoute,
    private toastr: ToastrService
  ) {
    this.eventForm = this.fb.group({
      name: ['', Validators.required],
      description: ['', Validators.required],
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
      location: ['', Validators.required],
    });

    this.eventId = this.route.snapshot.params['id'];
    
  }

  ngOnInit(): void {
    if (this.eventId != 'new') {
      this.eventService.getEvent(this.eventId).subscribe((event) => {
        this.eventForm.patchValue(event);
      });
    }
  }

  onSubmit(): void {
    if (this.eventForm.valid) {
      // Verifica se o formulário é válido
      if (this.eventId != 'new') {
        this.eventService
          .updateEvent(this.eventId, this.eventForm.value)
          .subscribe(() => {
            this.router.navigate(['/home']);
            this.toastr.warning('Evento editado com sucesso.', '', {
              progressBar: true,
            });
          });
      } else {
        this.eventService.createEvent(this.eventForm.value).subscribe(() => {
          this.router.navigate(['/home']);
          this.toastr.success('Evento cadastrado com sucesso.', '', {
            progressBar: true,
          });
        });
      }
    } else {
      // Exibir um toast de erro
      this.toastr.error(
        'Por favor, preencha todos os campos do formulário.',
        'Falha ao criar evento',
        { progressBar: true }
      );
    }
  }
}
