import { Component, EventEmitter, Input, OnInit, Output, ViewChild } from '@angular/core';

@Component({
  selector: 'app-commonmodel',
  templateUrl: './commonmodel.component.html',
  styleUrls: ['./commonmodel.component.css']
})
export class CommonmodelComponent implements OnInit {
  @Input() className:any="model-dialog model-md";
  @Input() closable=true;
  @Input() visible:boolean;
  @Input() visibleChange:EventEmitter<boolean>=new EventEmitter<boolean>();
  @Input() name: string;
  @ViewChild('closebutton') closebutton;
  display='none';
  
    constructor() { }
    @Input() title;
    @Input() isOpen=false;
    @Output() onClose = new EventEmitter<string>();
    ngOnInit() {
      console.log(this.title);
    }
    closePopup()
    {
      this.isOpen=false;
      this.onClose.emit('Pop up window closed');
    }
    public onSave() {
      this.closebutton.nativeElement.click();
    }
    openModal(){
      this.display='block';
   }
  }
  