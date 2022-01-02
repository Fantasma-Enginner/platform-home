import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { RecursosService, ResourceDTO } from '@tsir/resources-api';

@Component({
  selector: 'resources-modules',
  templateUrl: './resources.component.html',
  styleUrls: ['./resources.component.css']
})
export class ResourcesComponent implements OnInit {

  message?: string;
  error = false;
  success = false;

  sections: Domain[];
  resources: ResourceDTO[];
  selectedDomain: Domain;

  editForm: FormGroup;

  constructor(
    private resourcesService: RecursosService,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit() {
    this.initRegisterForm();
    this.setSecurityConfiguration();
    this.checkOptions();
  }

  private initRegisterForm() {
    this.editForm = this.formBuilder.group({
      file: [''],
      url: ['']
    });
  }

  private checkOptions(): void {
    this.resourcesService.findResources().subscribe(
      (data) => {
        this.resources = data;
        this.loadOptions();
      },
      (error) => {
        this.setError('Ha occurrido un error consultando recursos');
      }
    );
  }

  private setSecurityConfiguration(): void {
    this.resourcesService.configuration.accessToken = localStorage.getItem('token');
  }

  private loadOptions(): void {
    const mapDomains = new Map<number, Domain>();
    const mapModules = new Map<number, Module>();
    const mapOperations = new Map<number, Operation>();
    if (this.resources) {
      this.resources.forEach(r => {
        if (!r.parent && !mapDomains.has(r.id)) {
          mapDomains.set(r.id, new Domain(r.label, r.icon, []));
        } else {
          if (r.path) {
            const app = new Module(r.label, r.path, r.icon, []);
            const domain = mapDomains.get(r.parent);
            if (domain) {
              domain.modules.push(app);
            }
            mapModules.set(r.id, app);
          } else {
            const module = mapModules.get(r.parent);
            const operation = new Operation(r.id, r.code, r.label);
            if (module) {
              module.operations.push(operation);
            }
            mapOperations.set(r.id, operation);
          }
        }
      });
      this.sections = [...mapDomains.values()];
    }
  }

  private setSuccess(message: string) {
    this.success = true;
    this.error = false;
    this.message = message;
  }

  private setError(message: string) {
    this.success = false;
    this.error = true;
    this.message = message;
  }

  clearMessage(): void {
    this.error = false;
    this.success = false;
    this.message = null;
  }

  setSection(domain: Domain): void {
    this.selectedDomain = domain;
  }

}

export class Domain {

  constructor(public name: string, public icon: string, public modules: Module[]) {
  }

  isEmpty(): boolean {
    return this.modules ? this.modules.length === 0 : true;
  }

}

export class Module {

  constructor(public name: string, public url: string, public icon: string, public operations: Operation[]) {
  }

}

export class Operation {

  constructor(public id: number, public code: number, public name: string, public assign?: boolean) {
  }

}
