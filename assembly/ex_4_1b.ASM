	jmp	le
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
	

le:	in	00
	push	al
	and	al,f0
	cmp	al,30
	jnz     le
	
	
le2:	in	00
	push	al
	and	al,f0
	cmp	al,30
	jnz     le2
	pop	al
	pop	bl
	and	bl,0f
	and	al,0f
	mov	dl,29
	sub	dl,al
	mov	al,[dl]
	out	02
	mov	dl,19
	sub	dl,bl
	mov	al,[dl]
	out	02
	end
