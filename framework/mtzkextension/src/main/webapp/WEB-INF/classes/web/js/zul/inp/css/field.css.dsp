				.field {
				  display: flex;
				  flex-flow: column-reverse;
				}

				input.field {
				  font-size: 16px;
				  border: 0;
				  border-bottom: 1px solid #ccc;
				  font-family: inherit;
				  -webkit-appearance: none;
				  border-radius: 0;
				  padding: 0;
				  cursor: text;
				}
				
				::-webkit-input-placeholder {
				  opacity: 0;
				}

				label.field, input.field {
				  transition: all 0.2s;
				  touch-action: manipulation;
				}

				
				input.field:focus {
				  outline: 0;
				  border-bottom: 1px solid #666;
				}
				
				label.field {
				  font-size: 10px;
				  letter-spacing: 0.05em;
				  color:grey;
				  transform-origin: left bottom;
				  transform: translate(0, 1.2rem) scale(1.3);
				}
				
				input.field:not(:placeholder-shown) + label{
					transform-origin: left bottom;
					transform: translate(0, 0) ;
				}
				
				input.field:focus + label{
					transform-origin: left bottom;
					transform: translate(0, 0);
				}
				
				input:focus + label{
					transform-origin: left bottom;
					transform: translate(0, 0);
				}
				
				
				
				
				