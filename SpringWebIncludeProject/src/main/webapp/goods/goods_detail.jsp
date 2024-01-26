<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div id="goods" class="detail">
   
    <div class="section no-padding-vertical">
        <div class="wrapper side-paddings">
            <div class="product" style="display: flex; justify-content: center;">
            	<div class="product-top">
            		<div class="product-poster" style="display: inline-block;">
	                    <img alt="대표 이미지" src="${vo.poster}" style="width: 290px;height: 400px" />
	                </div>
	            
	                <div class="product-info" style="display: inline-block;">
	                    <h1 id="gname">${vo.gname}</h1>
	                    <p class="origin"><span>원산지 </span><span class="emph"> ${vo.origin}</span></p>
	                    <p class="manufacturer"><span>제조사 </span><span class="emph"> ${vo.manufacturer}</span></p>
	                    <p class="delivery-info"><span>배송</span><span class="emph"> 무료 배송</span></p>
                    	<p class="price"><span>가격 </span><span class="emph" id="price" data-price="${vo.price}"> ${vo.price}원</span></p>
                    	<!-- 수량 -->
                    	<p class="number">
                    		<span>수량 </span>
                    		<span class="emph">
								<select id="sel">
									<option value="1">1개</option>
									<option value="2">2개</option>
								 	<option value="3">3개</option>
								 	<option value="4">4개</option>
								 	<option value="5">5개</option>
								 	<option value="6">6개</option>
								 	<option value="7">7개</option>
									<option value="8">8개</option>
								 	<option value="9">9개</option>
								 	<option value="10">10개</option>
								</select>
							</span>
                    	</p>
	                </div>
            	</div>
            </div>
        </div>
    </div>
</div>