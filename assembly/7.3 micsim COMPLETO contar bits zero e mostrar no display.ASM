	jmp	inicio
	org	10
	db	de
	DB	Fe
	db	8a
	db	fc
	db	dc
	db	4e
	DB	9e
	DB	B6
	DB	0a	
	DB	Fa
	
	org	20
	db	df
	DB	FF
	db	8b
	db	fd
	db	dd
	db	4f
	DB	9F
	DB	B7
	DB	0B	
	DB	FB

inicio:	mov dl,00
	mov cl,01
	in 	00
	push 	al
	in 	00
	pop	bl
	and	bl,0f
	and	al,0f
	rol	bl
	rol	bl
	rol 	bl
	rol	bl
	xor	bl,al
	mov 	al,00

ciclo:	cmp 	al,08
	jz 	final
	and 	cl,bl
	cmp 	cl,01
	jz 	incre
	rol 	bl
	mov 	cl,01
	inc 	al
	jmp 	ciclo

incre:	inc 	dl
	rol 	bl
	mov 	cl,01
	inc 	al
	jmp 	ciclo

final:	push 	dl
	pop 	al
	mov	bl,00
	mov	dl,29
	sub	dl,al
	mov	al,[dl]
	out	02
	mov	dl,19
	sub	dl,bl
	mov	al,[dl]
	out	02
	end