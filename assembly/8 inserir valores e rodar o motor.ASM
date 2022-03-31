	mov	cl,11
	push	cl
	in	00
	push	al
	in	00
	pop	bl
	and	bl,0f
	and	al,0f
	rol	bl
	rol	bl
	rol	bl
	rol	bl
	or	bl,al
	push	bl
	in	00
	push	al
	pop	dl
	pop	bl
	pop	al
	cmp	dl,65
	jz	giroe
	jmp	girod

giroe:	ror	al	
	out	05
	dec	bl
	cmp	bl,00
	jz	final
	jmp 	giroe

girod:	rol	al	
	out	05
	dec	bl
	cmp	bl,00
	jz	final
	jmp	girod

final:	end
	